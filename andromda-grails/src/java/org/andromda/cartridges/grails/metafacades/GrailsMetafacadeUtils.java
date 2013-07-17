package org.andromda.cartridges.grails.metafacades;

import org.andromda.cartridges.grails.GrailsProfile;
import org.andromda.core.common.ExceptionUtils;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * Contains utilities specific to dealing with the Grails cartridge metafacades.
 * 
 * extracted from
 * org.andromda.cartridges.spring.metafacades.SpringMetafacadeUtils
 * 
 * @author Chad Brandon
 * @author Peter Friese
 */
class GrailsMetafacadeUtils
{
    /**
     * Creates a fully qualified name from the given <code>packageName</code>,
     * <code>name</code>, and <code>suffix</code>.
     * 
     * @param packageName
     *            the name of the model element package.
     * @param name
     *            the name of the model element.
     * @param suffix
     *            the suffix to append.
     * @return the new fully qualified name.
     */
    static String getFullyQualifiedName(String packageName, String name, String suffix)
    {
        StringBuffer fullyQualifiedName =
            new StringBuffer(StringUtils.trimToEmpty(packageName));
        if (StringUtils.isNotBlank(packageName))
        {
            fullyQualifiedName.append(".");
        }
        fullyQualifiedName.append(StringUtils.trimToEmpty(name));
        if (StringUtils.isNotEmpty(suffix))
        {
            fullyQualifiedName.append(StringUtils.trimToEmpty(suffix));
        }
        return fullyQualifiedName.toString();
    }

    /**
     * Creates a fully qualified name from the given <code>packageName</code>,
     * <code>name</code>, and <code>suffix</code>.
     * 
     * @param packageName
     *            the name of the model element package.
     * @param name
     *            the name of the model element.
     * @return the new fully qualified name.
     */
    static String getFullyQualifiedName(String packageName, String name)
    {
        return getFullyQualifiedName(packageName, name, null);
    }

    /**
     * Get the interceptors for the passed in <code>classifier</code>. If the
     * interceptors can be retrieved from the <code>classifier</code>, then
     * these will be used, otherwise the <code>defaultInterceptors</code> are
     * returned.
     * 
     * @param classifier
     *            the classifier whose interceptors we are looking for.
     * @param defaultInterceptors
     *            a list of interceptors to use if the classifier itself has no
     *            explicit interceptors.
     * 
     * @return String[] the interceptors.
     */
    static String[] getServiceInterceptors(ClassifierFacade classifier,
        String[] defaultInterceptors)
    {
        ExceptionUtils.checkNull("classifier", classifier);
        String[] interceptors = null;
        if (classifier.hasStereotype(UMLProfile.STEREOTYPE_SERVICE))
        {
            String interceptorsValue =
                (String) classifier
                    .findTaggedValue(GrailsProfile.TAGGEDVALUE_SPRING_SERVICE_INTERCEPTORS);
            // if the interceptors weren't found, search all super classes
            if (StringUtils.isEmpty(interceptorsValue))
            {
                interceptorsValue =
                    (String) CollectionUtils.find(classifier.getAllGeneralizations(),
                        new Predicate()
                        {
                            public boolean evaluate(Object object)
                            {
                                return ((ModelElementFacade) object)
                                    .findTaggedValue(GrailsProfile.TAGGEDVALUE_SPRING_SERVICE_INTERCEPTORS) != null;
                            }
                        });
            }
            // interceptors are a comma-separated list of strings, go and split
            // the list
            if (StringUtils.isNotEmpty(interceptorsValue))
            {
                interceptors = interceptorsValue.split(",");
            }
        }
        if (interceptors == null || interceptors.length == 0)
        {
            interceptors = defaultInterceptors;
        }
        return interceptors;
    }

}
