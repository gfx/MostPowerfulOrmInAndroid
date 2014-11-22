package net.pside.android.example.mostpowerfulorminandroid;

import android.test.AndroidTestCase;

import com.j256.ormlite.dao.Dao;

import net.pside.android.example.mostpowerfulorminandroid.helper.MySQLiteOpenHelper;
import net.pside.android.example.mostpowerfulorminandroid.model.Simple;
import net.pside.android.example.mostpowerfulorminandroid.util.TimingLogger;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by keima on 14/11/21.
 */
public class OrmLiteTest extends AndroidTestCase implements IOrmTestCase {
    public static final String TAG = OrmLiteTest.class.getSimpleName();

    private Dao<Simple, Long> mSimpleDao;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        resetDatabaseIfNeeded();

        MySQLiteOpenHelper sqLiteOpenHelper = new MySQLiteOpenHelper(getContext());

        mSimpleDao = sqLiteOpenHelper.getSimpleDao();
    }

    @Override
    protected void tearDown() throws Exception {
        Thread.sleep(2000);
        super.tearDown();
    }

    public void testSingleInsert() {

        TimingLogger logger = new TimingLogger(TAG, "SingleInsert on ORMLite");

        for (int i = 1; i <= IOrmTestCase.NUMBER_OF_INSERT_SINGLE; i++) {
            Simple simple = new Simple();
            simple.stringValue = "TestData" + i;
            simple.dateValue = new Date(i * 1000);
            simple.booleanValue = (i % 2 == 0);
            simple.shortValue = (short) i;
            simple.intValue = i;
            simple.longValue = i;
            simple.floatValue = i;
            simple.doubleValue = i;

            try {
                mSimpleDao.create(simple);
            } catch (SQLException e) {
                e.printStackTrace();
                fail();
            }
        }

        logger.addSplit("Insert " + IOrmTestCase.NUMBER_OF_INSERT_SINGLE + " records.");
        logger.dumpToLog();

    }

    public void testComplexInsert() {

    }


    private void resetDatabaseIfNeeded() {
        File databasePath = mContext.getDatabasePath(MySQLiteOpenHelper.DATABASE_NAME);
        if (databasePath != null && databasePath.exists()) {
            mContext.deleteDatabase(MySQLiteOpenHelper.DATABASE_NAME);
        }
    }

}
