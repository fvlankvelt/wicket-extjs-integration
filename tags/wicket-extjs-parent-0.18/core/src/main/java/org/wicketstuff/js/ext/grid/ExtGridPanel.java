package org.wicketstuff.js.ext.grid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wicketstuff.js.ext.ExtPanel;
import org.wicketstuff.js.ext.data.ExtStore;
import org.wicketstuff.js.ext.util.ExtClass;
import org.wicketstuff.js.ext.util.ExtProperty;
import org.wicketstuff.js.ext.util.ExtPropertyConverter;
import org.wicketstuff.js.ext.util.JSONIdentifier;

@ExtClass("Ext.grid.GridPanel")
public class ExtGridPanel<T> extends ExtPanel {

    @ExtProperty
    protected String autoExpandColumn;
    @ExtProperty
    protected Boolean stripeRows;

    private ExtStore<T> store;
    private ExtColumn[] columns;

    public ExtGridPanel(String id) {
        super(id);
    }

    @Override
    protected void preRenderExtHead(StringBuilder js) {
        store.onRenderExtHead(js);

        super.preRenderExtHead(js);
    }

    @Override
    protected void onRenderProperties(JSONObject properties) throws JSONException {
        super.onRenderProperties(properties);

        properties.put("store", new JSONIdentifier(store.getJsObjectId()));

        JSONArray jsonColumns = new JSONArray();
        for (ExtColumn column : columns) {
            JSONObject jsonColumn = new JSONObject();
            ExtPropertyConverter.setIfNotNull(jsonColumn, "id", column.getId());
            ExtPropertyConverter.setIfNotNull(jsonColumn, "header", column.getHeader());
            ExtPropertyConverter.setIfNotNull(jsonColumn, "width", column.getWidth());
            ExtPropertyConverter.setIfNotNull(jsonColumn, "sortable", column.getSortable());
            ExtPropertyConverter.setIfNotNull(jsonColumn, "dataIndex", column.getDataIndex());
            ExtPropertyConverter.setIfNotNull(jsonColumn, "renderer", column.getRenderer());

            jsonColumns.put(jsonColumn);
        }

        properties.put("columns", jsonColumns);
    }

    public void setAutoExpandColumn(String autoExpandColumn) {
        this.autoExpandColumn = autoExpandColumn;
    }

    public void setColumns(ExtColumn... columns) {
        this.columns = columns;
    }

    public void setStore(ExtStore<T> store) {
        this.store = store;
    }

    public void setStripeRows(Boolean stripeRows) {
        this.stripeRows = stripeRows;
    }

}