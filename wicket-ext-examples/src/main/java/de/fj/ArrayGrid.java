package de.fj;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import de.fj.wickx.data.ExtArrayStore;
import de.fj.wickx.data.ExtField;
import de.fj.wickx.data.ExtStore;
import de.fj.wickx.grid.ExtColumn;
import de.fj.wickx.grid.ExtGridPanel;
import de.fj.wickx.util.ExtColumnRenderer;
import de.fj.wickx.util.Renderer;

public class ArrayGrid extends WebPage {
	protected class Data {
		private String company;
		private Float price;
		private Float change;
		private Float pctChange;
		private Date lastChange;

		public Data(String company, Float price, Float change, Float pctChange, Date lastChange) {
			super();
			this.company = company;
			this.price = price;
			this.change = change;
			this.pctChange = pctChange;
			this.lastChange = lastChange;
		}

		public String getCompany() {
			return company;
		}

		public Float getPrice() {
			return price;
		}

		public Float getChange() {
			return change;
		}

		public Float getPctChange() {
			return pctChange;
		}

		public Date getLastChange() {
			return lastChange;
		}
	}

	public ArrayGrid() {
		List<Data> myData = new ArrayList<Data>();
		DateFormat dateFormat = new SimpleDateFormat("d/M HH:mma");

		try {
			myData.add(new Data("3m Co", 71.72f, 0.02f, 0.03f, dateFormat.parse("9/1 12:00am")));

			myData.add(new Data("Alcoa Inc", 29.01f, 0.42f, 1.47f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("Altria Group Inc", 83.81f, 0.28f, 0.34f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("American Express Company", 52.55f, 0.01f, 0.02f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("American International Group, Inc.", 64.13f, 0.31f, 0.49f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("AT&T Inc.", 31.61f, -0.48f, -1.54f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("Boeing Co.", 75.43f, 0.53f, 0.71f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("Caterpillar Inc.", 67.27f, 0.92f, 1.39f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("Citigroup, Inc.", 49.37f, 0.02f, 0.04f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("E.I. du Pont de Nemours and Company", 40.48f, 0.51f, 1.28f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Exxon Mobil Corp", 68.1f, -0.43f, -0.64f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("General Electric Company", 34.14f, -0.08f, -0.23f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("General Motors Corporation", 30.27f, 1.09f, 3.74f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Hewlett-Packard Co.", 36.53f, -0.03f, -0.08f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Honeywell Intl Inc", 38.77f, 0.05f, 0.13f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("Intel Corporation", 19.88f, 0.31f, 1.58f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("International Business Machines", 81.41f, 0.44f, 0.54f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Johnson & Johnson", 64.72f, 0.06f, 0.09f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("JP Morgan & Chase & Co", 45.73f, 0.07f, 0.15f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("McDonald's Corporation", 36.76f, 0.86f, 2.40f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Merck & Co., Inc.", 40.96f, 0.41f, 1.01f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("Microsoft Corporation", 25.84f, 0.14f, 0.54f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Pfizer Inc", 27.96f, 0.4f, 1.45f, dateFormat.parse("9/1 12:00am")));
			myData.add(new Data("The Coca-Cola Company", 45.07f, 0.26f, 0.58f, dateFormat
					.parse("9/1 12:00am")));
			myData
					.add(new Data("The Home Depot, Inc.", 34.64f, 0.35f, 1.02f, dateFormat
							.parse("9/1 12:00am")));
			myData.add(new Data("The Procter & Gamble Company", 61.91f, 0.01f, 0.02f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("United Technologies Corporation", 63.26f, 0.55f, 0.88f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Verizon Communications", 35.57f, 0.39f, 1.11f, dateFormat
					.parse("9/1 12:00am")));
			myData.add(new Data("Wal-Mart Stores, Inc.", 45.45f, 0.73f, 1.63f, dateFormat
					.parse("9/1 12:00am")));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		ExtStore<Data> store = new ExtArrayStore<Data>(Arrays.asList(new ExtField("company"), new ExtField(
				"price"), new ExtField("change"), new ExtField("pctChange"), new ExtField("lastChange")));

		store.loadData(myData);

		ExtGridPanel<Data> grid = new ExtGridPanel<Data>("grid-example");
		grid.setStore(store);

		ExtColumn column1 = new ExtColumn();
		column1.setId("company");
		column1.setHeader(new Model<String>("Company"));
		column1.setWidth(160);
		column1.setSortable(true);
		column1.setDataIndex("company");

		ExtColumn column2 = new ExtColumn();
		column2.setHeader(new Model<String>("Price"));
		column2.setWidth(75);
		column2.setSortable(true);
		column2.setRenderer(Renderer.usMoney);
		column2.setDataIndex("price");

		ExtColumn column3 = new ExtColumn();
		column3.setHeader(new Model<String>("Change"));
		column3.setWidth(75);
		column3.setSortable(true);
		column3.setRenderer(new ExtColumnRenderer() {
			@Override
			public String getString(Object value, int row) {
				Float change = (Float) value;
				if (change > 0) {
					return "<span style=\"color:green;\">" + change + "</span>";
				} else if (change < 0) {
					return "<span style=\"color:red;\">" + change + "</span>";
				}
				return change.toString();
			}
		});
		column3.setDataIndex("change");

		ExtColumn column4 = new ExtColumn();
		column4.setHeader(new Model<String>("% Change"));
		column4.setWidth(75);
		column4.setSortable(true);
		// column4.setRenderer("pctChange");
		column4.setDataIndex("pctChange");

		ExtColumn column5 = new ExtColumn();
		column5.setHeader(new Model<String>("Last Updated"));
		column5.setWidth(85);
		column5.setSortable(true);
		// column5.setRenderer(new DateRenderer("d/m/Y");
		column5.setDataIndex("lastChange");

		grid.setColumns(column1, column2, column3, column4, column5);

		grid.setStripeRows(true);
		grid.setAutoExpandColumn("company");
		grid.setHeight(350);
		grid.setWidth(600);
		grid.setTitle(new Model<String>("Array Grid"));
		grid.setStateful(true);
		grid.setStateId("grid");
		add(grid);
	}
}