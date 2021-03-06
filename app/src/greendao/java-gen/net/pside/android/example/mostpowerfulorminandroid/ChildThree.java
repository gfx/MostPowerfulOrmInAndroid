package net.pside.android.example.mostpowerfulorminandroid;

import net.pside.android.example.mostpowerfulorminandroid.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CHILD_THREE.
 */
public class ChildThree {

    private Long id;
    private Long ChildFourId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ChildThreeDao myDao;

    private ChildThree childThree;
    private Long childThree__resolvedKey;


    public ChildThree() {
    }

    public ChildThree(Long id) {
        this.id = id;
    }

    public ChildThree(Long id, Long ChildFourId) {
        this.id = id;
        this.ChildFourId = ChildFourId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getChildThreeDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChildFourId() {
        return ChildFourId;
    }

    public void setChildFourId(Long ChildFourId) {
        this.ChildFourId = ChildFourId;
    }

    /** To-one relationship, resolved on first access. */
    public ChildThree getChildThree() {
        Long __key = this.ChildFourId;
        if (childThree__resolvedKey == null || !childThree__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChildThreeDao targetDao = daoSession.getChildThreeDao();
            ChildThree childThreeNew = targetDao.load(__key);
            synchronized (this) {
                childThree = childThreeNew;
            	childThree__resolvedKey = __key;
            }
        }
        return childThree;
    }

    public void setChildThree(ChildThree childThree) {
        synchronized (this) {
            this.childThree = childThree;
            ChildFourId = childThree == null ? null : childThree.getId();
            childThree__resolvedKey = ChildFourId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
