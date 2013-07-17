package org.andromda.cartridges.grails.metafacades;

import java.util.Collection;

import org.andromda.cartridges.grails.GrailsProfile;
import org.andromda.metafacades.uml.FilteredCollection;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author stephane.manciot@ebiznext.com
 * 
 * MetafacadeLogic implementation for
 * org.andromda.cartridges.grails.metafacades.GrailsService.
 * 
 * @see org.andromda.cartridges.grails.metafacades.GrailsService
 */
public class GrailsServiceLogicImpl extends GrailsServiceLogic
{

    /**
     * 
     */
    private static final String SERVICE_BASE_SUFFIX = "Base";

    public GrailsServiceLogicImpl(Object metaObject, String context)
    {
        super(metaObject, context);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getInterceptors()
     */
    protected java.lang.String[] handleGetInterceptors()
    {
        String serviceInterceptorString =
            this.isConfiguredProperty("serviceInterceptors") ? ObjectUtils.toString(this
                .getConfiguredProperty("serviceInterceptors")) : null;
        String[] interceptors = null;
        if (StringUtils.isNotEmpty(serviceInterceptorString))
        {
            interceptors = serviceInterceptorString.split(",");
        }
        return GrailsMetafacadeUtils.getServiceInterceptors(this, interceptors);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getImplementationName()
     */
    protected java.lang.String handleGetImplementationName()
    {
        return this.getName();
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#isHibernateInterceptorEnabled()
     */
    protected boolean handleIsHibernateInterceptorEnabled()
    {
        return Boolean.valueOf(
            String.valueOf(this.getConfiguredProperty("serviceHibernateInterceptorEnabled")))
            .booleanValue();
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getFullyQualifiedImplementationName()
     */
    protected java.lang.String handleGetFullyQualifiedImplementationName()
    {
        return GrailsMetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this
            .getName(), null);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getFullyQualifiedDefaultExceptionName()
     */
    protected java.lang.String handleGetFullyQualifiedDefaultExceptionName()
    {
        StringBuffer fullyQualifiedName = new StringBuffer("java.lang.RuntimeException");
        if (this.isAllowDefaultServiceException())
        {
            fullyQualifiedName = new StringBuffer();
            if (StringUtils.isNotBlank(this.getPackageName()))
            {
                fullyQualifiedName.append(this.getPackageName());
                fullyQualifiedName.append('.');
            }
            fullyQualifiedName.append(this.getDefaultExceptionName());
        }
        return fullyQualifiedName.toString();
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getFullyQualifiedBaseName()
     */
    protected java.lang.String handleGetFullyQualifiedBaseName()
    {
        return GrailsMetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this
            .getName(), SERVICE_BASE_SUFFIX);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getDefaultExceptionName()
     */
    protected java.lang.String handleGetDefaultExceptionName()
    {
        String name =
            StringUtils.trimToEmpty(String.valueOf(this
                .getConfiguredProperty("defaultServiceExceptionNamePattern")));
        return name.replaceAll("\\{0\\}", this.getName());
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#isConfigonly()
     */
    protected boolean handleIsConfigonly()
    {
        String value =
            (String) this.findTaggedValue(GrailsProfile.TAGGEDVALUE_SERVICE_CONFIG_ONLY);
        return BooleanUtils.toBoolean(StringUtils.trimToEmpty(value));
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getBeanName()
     */
    protected java.lang.String handleGetBeanName()
    {
        return this.getBeanName(false);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getBaseName()
     */
    protected java.lang.String handleGetBaseName()
    {
        return this.getName() + SERVICE_BASE_SUFFIX;
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#isAllowDefaultServiceException()
     */
    protected boolean handleIsAllowDefaultServiceException()
    {
        return Boolean.valueOf(
            String.valueOf(this.getConfiguredProperty("defaultServiceExceptions")))
            .booleanValue();
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getBeanName(boolean)
     */
    protected java.lang.String handleGetBeanName(boolean targetSuffix)
    {
        StringBuffer beanName =
            new StringBuffer(StringUtils.uncapitalize(StringUtils.trimToEmpty(this.getName())));
        if (targetSuffix)
        {
            beanName.append("Target");
        }
        return beanName.toString();
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getFullyQualifiedInterfaceName()
     */
    protected String handleGetFullyQualifiedInterfaceName()
    {
        return GrailsMetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this
            .getInterfaceName(), null);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsService#getInterfaceName()
     */
    protected String handleGetInterfaceName()
    {
        return "I" + this.getName();
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceLogic#handleIsWebService()
     */
    protected boolean handleIsWebService()
    {
        boolean webService = this.hasStereotype(GrailsProfile.STEREOTYPE_WEBSERVICE);
        if (!webService)
        {
            webService = !this.getWebServiceOperations().isEmpty();
        }
        return webService;
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceLogic#handleGetWebServiceOperations()
     */
    protected Collection handleGetWebServiceOperations()
    {
        Collection operations = this.getOperations();
        if (!this.hasStereotype(GrailsProfile.STEREOTYPE_WEBSERVICE))
        {
            operations = new FilteredCollection(operations)
                {
                    public boolean evaluate(Object object)
                    {
                        return object instanceof GrailsServiceOperation && ((GrailsServiceOperation)object).isWebserviceExposed();
                    }
                };
        }
        return operations;
    }

}
