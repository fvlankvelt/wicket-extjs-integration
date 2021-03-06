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

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.Model;
import org.wicketstuff.js.ext.util.ExtEventListener;

public class Tabs extends ExamplesPage {

    private static final String SHORT_TEXT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus.\n \n Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.";
    private static final String LONG_TEXT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.\n\nAliquam commodo ullamcorper erat. Nullam vel justo in neque porttitor laoreet. Aenean lacus dui, consequat eu, adipiscing eget, nonummy non, nisi. Morbi nunc est, dignissim non, ornare sed, luctus eu, massa. Vivamus eget quam. Vivamus tincidunt diam nec urna. Curabitur velit.";

    public Tabs() {
        ExtTabPanel tabs1 = new ExtTabPanel("tabs1");
        tabs1.setWidth(450);
        tabs1.setActiveTab(0);
        tabs1.setFrame(true);
        ExtPanel tab1 = new TextPanel();
        tab1.setAutoHeight(true);
        tab1.add(new MultiLineLabel("text", SHORT_TEXT));
        tabs1.addTab(new Model<String>("Short Text"), tab1);
        ExtPanel tab2 = new TextPanel();
        tab2.setAutoHeight(true);
        tab2.add(new MultiLineLabel("text", LONG_TEXT));
        tabs1.addTab(new Model<String>("Long Text"), tab2);

        add(tabs1);

        ExtTabPanel tabs2 = new ExtTabPanel("tabs2");
        tabs2.setActiveTab(0);
        tabs2.setWidth(600);
        tabs2.setHeight(250);
        tabs2.setPlain(true);
        tab1 = new TextPanel();
        tab1.setAutoScroll(true);
        tab1.add(new MultiLineLabel("text", "My content was added during construction."));
        tabs2.addTab(new Model<String>("Normal Tab"), tab1);
        tab2 = new TextPanel();
        tab2.setAutoScroll(true);
        tab2.add(new MultiLineLabel("text", LONG_TEXT));
        tabs2.addTab(new Model<String>("Ajax Tab 1"), tab2);

        ExtPanel tab3 = new TextPanel();
        tab3.setAutoScroll(true);
        tab3.add(new MultiLineLabel("text", LONG_TEXT));
        tabs2.addTab(new Model<String>("Ajax Tab 2"), tab3);

        final ExtPanel tab4 = new TextPanel();
        tab4.setAutoScroll(true);
        tab4.add(new MultiLineLabel("text", "I am tab 4's content. I also have an event listener attached."));
        tab4.addEventListener("activate", new ExtEventListener() {
            @Override
            public void onEvent(AjaxRequestTarget target) {
                target.prependJavaScript("alert('" + tab4.getTitle().getObject() + " was activated');");
            }
        });
        tabs2.addTab(new Model<String>("Event Tab"), tab4);

        ExtPanel tab5 = new TextPanel();
        tab5.setAutoScroll(true);
        tab5.add(new MultiLineLabel("text", "Can't see me cause I'm disabled"));
        tab5.setDisabled(true);
        tabs2.addTab(new Model<String>("Disabled Tab"), tab5);

        add(tabs2);
    }

}
