package de.fj.wickx.form;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import de.fj.wickx.ExtBoxComponent;
import de.fj.wickx.ExtComponent;
import de.fj.wickx.util.ExtProperty;

public class ExtField<T> extends ExtBoxComponent {

	@ExtProperty
	protected String name;
	@ExtProperty
	protected IModel<T> value;
	
	protected TextField<T> field;
	
	public ExtField(String id) {
		this(id, null);
	}
	
	public ExtField(String id, IModel<T> model) {
		super(id);
		this.value = model;

		field = new TextField<T>("field", model);
		add(field);
		field.setRenderBodyOnly(true);
	}
	

	@Override
	protected void onRenderProperties() {
		setName(field.getInputName());
		super.onRenderProperties();
	}
	
	
	@Override
	public List<ExtComponent> getItems() {
		return Collections.emptyList();
	}

	public void setName(String name) {
		this.name = name;
	}

}
