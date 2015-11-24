package net.pside.android.example.mostpowerfulorminandroid;

import com.github.gfx.android.orma.Inserter;
import com.github.gfx.android.orma.TransactionTask;
import com.github.gfx.android.orma.adapter.TypeAdapterRegistry;

import net.pside.android.example.mostpowerfulorminandroid.model.OrmaDatabase;
import net.pside.android.example.mostpowerfulorminandroid.model.Simple;
import net.pside.android.example.mostpowerfulorminandroid.util.TimingLogger;

import android.support.annotation.NonNull;

import java.util.Date;
import java.util.List;

public class OrmaTest extends OrmTestCase {
    public static final String TAG = OrmaTest.class.getSimpleName();

    OrmaDatabase db;

    @NonNull
    @Override
    protected String getDatabaseName() {
        return "orma.db";
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        db = new OrmaDatabase(getContext(), getDatabaseName());
        db.addTypeAdapters(TypeAdapterRegistry.defaultTypeAdapters());
        db.getConnection().resetDatabase();
    }

    @Override
    public void testSingleInsert() {
        insert(false);
    }

    @Override
    public void testSingleBulkInsert() {
        insert(true);
    }

    public void insert(boolean isBulkMode) {
        TimingLogger logger = new TimingLogger(TAG, MSG_LOGGER_INITIALIZE(isBulkMode));

        if (isBulkMode) {
            db.transaction(new TransactionTask() {
                @Override
                public void execute() throws Exception {
                    Inserter<Simple> inserter = db.prepareInsertIntoSimple();
                    for (int i = 1; i <= IOrmTestCase.NUMBER_OF_INSERT_SINGLE; i++) {
                        inserter.execute(createSimple(i));
                    }
                }
            });
        } else {
            for (int i = 1; i <= IOrmTestCase.NUMBER_OF_INSERT_SINGLE; i++) {
                db.insertIntoSimple(createSimple(i));
            }
        }

        logger.addSplit(MSG_LOGGER_SPLIT_INSERT);

        List<Simple> simpleList = db.selectFromSimple()
                .where("booleanValue = ?", true)
                .toList();

        assertEquals(NUMBER_OF_INSERT_SINGLE / 2, simpleList.size());

        logger.addSplit(MSG_LOGGER_SPLIT_SELECT);
        logger.dumpToLog();
    }

    private Simple createSimple(int i) {
        Simple simple = new Simple();
        simple.stringValue = "TestData" + i;
        simple.dateValue = new Date(i * 1000);
        simple.booleanValue = (i % 2 == 0);
        simple.shortValue = (short) i;
        simple.intValue = i;
        simple.longValue = i;
        simple.floatValue = i;
        simple.doubleValue = i;
        return simple;
    }
}
