/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicketstuff.js.ext;

//Ext.getCmp('center-panel')

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.Model;
import org.wicketstuff.js.ext.ExtWindow.CloseAction;
import org.wicketstuff.js.ext.layout.FitLayout;

public class HelloWorld extends ExamplesPage {

    public HelloWorld() {
        final ExtWindow win = new ExtWindow("win");
        win.setTitle(new Model<String>("Hello Dialog"));
        win.setLayout(new FitLayout());
        win.setWidth(500);
        win.setHeight(300);
        win.setCloseAction(CloseAction.HIDE);
        win.setPlain(true);

        final ExtTabPanel tabs = new ExtTabPanel();
        //tabs.setAutoTabs(true);
        tabs.setActiveTab(0);
        tabs.setDeferredRender(false);
        tabs.setBorder(false);

        ExtPanel tab1 = new TextPanel();
        tab1.add(new MultiLineLabel("text", "Hello..."));

        ExtPanel tab2 = new TextPanel();
        tab2.add(new MultiLineLabel("text", "... World!"));

        tabs.addTab(new Model<String>("Hello World 1"), tab1);
        tabs.addTab(new Model<String>("Hello World 2"), tab2);
        win.addItem(tabs);

        ExtButton extButton = new ExtButton(new Model<String>("Submit"));
        extButton.setDisabled(true);
        win.addButton(extButton);

        win.addButton(new ExtButton(new Model<String>("Close")) {
            @Override
            protected void onClick(AjaxRequestTarget target) {
                win.hide();
            }
        });
        add(win);

        add(new WebMarkupContainer("showButton").add(new AjaxEventBehavior("onclick") {
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                win.show();
            }
        }));

    }

}
