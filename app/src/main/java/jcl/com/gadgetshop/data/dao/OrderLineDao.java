package jcl.com.gadgetshop.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER_LINE".
*/
public class OrderLineDao extends AbstractDao<OrderLine, Long> {

    public static final String TABLENAME = "ORDER_LINE";

    /**
     * Properties of entity OrderLine.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ProductId = new Property(1, Long.class, "productId", false, "PRODUCT_ID");
        public final static Property Quantity = new Property(2, int.class, "quantity", false, "QUANTITY");
    }


    public OrderLineDao(DaoConfig config) {
        super(config);
    }
    
    public OrderLineDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_LINE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PRODUCT_ID\" INTEGER," + // 1: productId
                "\"QUANTITY\" INTEGER NOT NULL );"); // 2: quantity
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_LINE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderLine entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long productId = entity.getProductId();
        if (productId != null) {
            stmt.bindLong(2, productId);
        }
        stmt.bindLong(3, entity.getQuantity());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderLine entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long productId = entity.getProductId();
        if (productId != null) {
            stmt.bindLong(2, productId);
        }
        stmt.bindLong(3, entity.getQuantity());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public OrderLine readEntity(Cursor cursor, int offset) {
        OrderLine entity = new OrderLine( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // productId
            cursor.getInt(offset + 2) // quantity
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderLine entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setProductId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setQuantity(cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(OrderLine entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(OrderLine entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(OrderLine entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
