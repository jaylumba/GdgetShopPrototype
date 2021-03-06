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
 * DAO for table "ORDER_MAPPING".
*/
public class OrderMappingDao extends AbstractDao<OrderMapping, Void> {

    public static final String TABLENAME = "ORDER_MAPPING";

    /**
     * Properties of entity OrderMapping.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property OrderId = new Property(0, Long.class, "orderId", false, "ORDER_ID");
        public final static Property OrderLineId = new Property(1, Long.class, "orderLineId", false, "ORDER_LINE_ID");
    }


    public OrderMappingDao(DaoConfig config) {
        super(config);
    }
    
    public OrderMappingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_MAPPING\" (" + //
                "\"ORDER_ID\" INTEGER UNIQUE ," + // 0: orderId
                "\"ORDER_LINE_ID\" INTEGER UNIQUE );"); // 1: orderLineId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_MAPPING\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderMapping entity) {
        stmt.clearBindings();
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(1, orderId);
        }
 
        Long orderLineId = entity.getOrderLineId();
        if (orderLineId != null) {
            stmt.bindLong(2, orderLineId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderMapping entity) {
        stmt.clearBindings();
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(1, orderId);
        }
 
        Long orderLineId = entity.getOrderLineId();
        if (orderLineId != null) {
            stmt.bindLong(2, orderLineId);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public OrderMapping readEntity(Cursor cursor, int offset) {
        OrderMapping entity = new OrderMapping( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // orderId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) // orderLineId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderMapping entity, int offset) {
        entity.setOrderId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOrderLineId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(OrderMapping entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(OrderMapping entity) {
        return null;
    }

    @Override
    public boolean hasKey(OrderMapping entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
