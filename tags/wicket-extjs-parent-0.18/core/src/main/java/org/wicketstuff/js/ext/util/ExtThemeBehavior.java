package org.wicketstuff.js.ext.util;

import java.util.Locale;

import org.apache.wicket.Component;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.Session;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.PackageResource;
import org.apache.wicket.util.string.Strings;
import org.wicketstuff.js.ext.ExtBundle;

/**
 * Adds the default ExtJs theme CSS to the header.
 */
public class ExtThemeBehavior extends AbstractBehavior {

    @Override
    public final void bind(Component component) {
        onBind(component);

        final String resourcePath = getLocalizedResource();
        if (resourcePath != null) {
            component.add(new HeaderContributor(new IHeaderContributor() {
                private static final long serialVersionUID = 1L;

                public void renderHead(IHeaderResponse response) {
                    ResourceReference reference = new ResourceReference(ExtBundle.class, resourcePath);
                    reference.setStateless(true);
                    response.renderJavascriptReference(reference);
                }
            }));
        }
    }

    protected void onBind(Component component) {
        component.add(CSSPackageResource.getHeaderContribution(ExtBundle.class, ExtBundle.EXT_ALL_STYLE));
    }

    private String getLocalizedResource() {
        String path = "src/locale/ext-lang-";
        Locale locale = Session.get().getLocale();

        // Get language and country, either of which may be the empty string
        final String language = locale.getLanguage();
        final String country = locale.getCountry();
        final String variant = locale.getVariant();

        if (!Strings.isEmpty(variant)) {
            if (resourceExists(path, locale)) {
                return getResource(path, locale);
            }
        }

        Locale currentLocale;
        if (!Strings.isEmpty(language) && !Strings.isEmpty(country)) {
            currentLocale = new Locale(language, country);
            if (resourceExists(path, currentLocale)) {
                return getResource(path, currentLocale);
            }
        }

        if (!Strings.isEmpty(language)) {
            currentLocale = new Locale(language);
            if (resourceExists(path, currentLocale)) {
                return getResource(path, currentLocale);
            }
        }
        return null;
    }


    private String getResource(final String path, final Locale locale) {
        return path + locale.toString() + ".js";
    }

    private boolean resourceExists(final String path, final Locale locale) {
        return PackageResource.exists(ExtBundle.class, path + locale.toString() + ".js", null, null);
    }
}