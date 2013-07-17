package org.andromda.cartridges.grails.metafacades;

import org.andromda.cartridges.grails.GrailsProfile;
import org.apache.commons.lang.StringUtils;

/**
 * @author stephane.manciot@ebiznext.com
 * 
 * MetafacadeLogic implementation for
 * org.andromda.cartridges.grails.metafacades.GrailsServiceOperation.
 * 
 * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation
 */
public class GrailsServiceOperationLogicImpl extends GrailsServiceOperationLogic
{

    /**
     * The transaction type for Spring service operations.
     */
    private static final String SERVICE_OPERATION_TRANSACTION_TYPE =
                                                                       "serviceOperationTransactionType";

    public GrailsServiceOperationLogicImpl(Object metaObject, String context)
    {
        super(metaObject, context);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation#getThrowsClause()
     */
    protected java.lang.String handleGetThrowsClause()
    {
        StringBuffer throwsClause = null;
        if (this.isExceptionsPresent())
        {
            throwsClause = new StringBuffer(this.getExceptionList());
        }
        if (throwsClause != null)
        {
            throwsClause.insert(0, "throws ");
        }
        return throwsClause != null ? throwsClause.toString() : null;
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation#getImplementationSignature()
     */
    protected java.lang.String handleGetImplementationSignature()
    {
        return this.getImplementationOperationName(StringUtils.capitalize(this.getSignature()));
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation#getImplementationName()
     */
    protected java.lang.String handleGetImplementationName()
    {
        return this.getImplementationOperationName(StringUtils.capitalize(this.getName()));
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation#getImplementationCall()
     */
    protected java.lang.String handleGetImplementationCall()
    {
        return this.getImplementationOperationName(StringUtils.capitalize(this.getCall()));
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation#getTransactionType()
     */
    protected java.lang.String handleGetTransactionType()
    {
        String transactionType =
            (String) this.findTaggedValue(GrailsProfile.TAGGEDVALUE_TRANSACTION_TYPE);
        if (StringUtils.isBlank(transactionType))
        {
            transactionType =
                (String) this.getOwner().findTaggedValue(
                    GrailsProfile.TAGGEDVALUE_TRANSACTION_TYPE);
        }
        if (StringUtils.isBlank(transactionType))
        {
            transactionType =
                String.valueOf(this.getConfiguredProperty(SERVICE_OPERATION_TRANSACTION_TYPE));
        }
        return transactionType;
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperation#getThrowsClause(java.lang.String)
     */
    protected java.lang.String handleGetThrowsClause(java.lang.String initialExceptions)
    {
        final StringBuffer throwsClause = new StringBuffer(initialExceptions);
        if (this.getThrowsClause() != null)
        {
            throwsClause.insert(0, ", ");
            throwsClause.insert(0, this.getThrowsClause());
        }
        else
        {
            throwsClause.insert(0, "throws ");
        }
        return throwsClause.toString();
    }

    /**
     * Retrieves the implementationOperatName by replacing the
     * <code>replacement</code> in the
     * {@link SpringGlobals#IMPLEMENTATION_OPERATION_NAME_PATTERN}
     * 
     * @param replacement
     *            the replacement string for the pattern.
     * @return the operation name
     */
    private String getImplementationOperationName(String replacement)
    {
        return StringUtils.trimToEmpty(
            String.valueOf(this.getConfiguredProperty("implementationOperationNamePattern")))
            .replaceAll("\\{0\\}", replacement);
    }

    /**
     * @see org.andromda.cartridges.grails.metafacades.GrailsServiceOperationLogic#handleIsWebserviceExposed()
     */
    protected boolean handleIsWebserviceExposed()
    {
        return this.hasStereotype(GrailsProfile.STEREOTYPE_WEBSERVICE_OPERATION);
    }

}
