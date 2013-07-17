package org.andromda.cartridges.grails;

import org.andromda.core.profile.Profile;
import org.andromda.metafacades.uml.UMLProfile;


/**
 * @author stephane.manciot@ebiznext.com
 * 
 * The Grails profile. Contains the profile information (tagged values, and stereotypes) for the Grails cartridge.
 *
 */
public class GrailsProfile
    extends UMLProfile
{
    /**
     * The Profile instance from which we retrieve the mapped profile names.
     */
    private static final Profile profile = Profile.instance();

    /* ----------------- Stereotypes -------------------- */
    /**
     * 
     */
    public static final String STEREOTYPE_CONSTRAINT = profile.get("CONSTRAINT");

    /**
     * 
     */
    public static final String STEREOTYPE_CUSTOM_VALIDATOR = profile.get("CUSTOM_VALIDATOR");

    /* ----------------- Tagged Values -------------------- */

    /**
     * Stores the Web Flow exception type
     */
    public static final String TAGGEDVALUE_WEB_FLOW_EXCEPTION_TYPE = profile.get("EXCEPTION_TYPE");

    /**
     * Stores the GORM attribute constraint type
     */
    public static final String TAGGEDVALUE_GORM_CONSTRAINT_TYPE = profile.get("GORM_CONSTRAINT_TYPE");

    /**
     * Stores the GORM regular expression constraint
     */
    public static final String TAGGEDVALUE_GORM_CONSTRAINT_MATCHES = profile.get("GORM_CONSTRAINT_MATCHES");

    /**
     * Stores the GORM range constraint
     */
    public static final String TAGGEDVALUE_GORM_CONSTRAINT_RANGE = profile.get("GORM_CONSTRAINT_RANGE");

    /**
     * Stores the EJB service transaction type.
     */
    public static final String TAGGEDVALUE_EJB_TRANSACTION_TYPE = profile.get("EJB_TRANSACTION_TYPE");

    /**
     * Stores the EJB service view type (local/remote).
     */
    public static final String TAGGEDVALUE_EJB_VIEW_TYPE = profile.get("EJB_VIEW_TYPE");

    /**
     * Stores the Spring service transaction type.
     */
    public static final String TAGGEDVALUE_TRANSACTION_TYPE = profile.get("TRANSACTION_TYPE");

    /**
     * Stores whether a criteria search attribute may be nullable.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_NULLABLE = profile.get("HIBERNATE_CRITERIA_NULLABLE");

    /**
     * Stores a criteria search attribute path.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_ATTRIBUTE = profile.get("HIBERNATE_CRITERIA_ATTRIBUTE");

    /**
     * Stores a criteria search comparator.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_COMPARATOR = profile.get("HIBERNATE_CRITERIA_COMPARATOR");

    /**
     * Stores a hibernate matchmode.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_MATCHMODE = profile.get("HIBERNATE_CRITERIA_MATCHMODE");

    /**
     * Stores the criteria search order direction.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_ORDER_DIRECTION =
        profile.get("HIBERNATE_CRITERIA_ORDER_DIRECTION");

    /**
     * Stores the criteria search order relevance.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_ORDER_RELEVANCE =
        profile.get("HIBERNATE_CRITERIA_ORDER_RELEVANCE");

    /**
     * Stores whether or not criteria like comparator's should ignore case.
     */
    public static final String TAGGEDVALUE_HIBERNATE_CRITERIA_COMPARATOR_IGNORE_CASE =
        profile.get("HIBERNATE_CRITERIA_COMPARATOR_IGNORE_CASE");

    /**
     * Stores a hibernate query.
     */
    public static final String TAGGEDVALUE_HIBERNATE_QUERY = profile.get("HIBERNATE_QUERY");

    /**
     * Stores the hibernate inheritance use for entities.
     */
    public static final String TAGGEDVALUE_HIBERNATE_INHERITANCE = profile.get("HIBERNATE_INHERITANCE");

    /**
     * Define whether the marked finder will use named parameters or positional parameters.
     */
    public static final String TAGGEDVALUE_HIBERNATE_USE_NAMED_PARAMETERS = profile
            .get("HIBERNATE_USE_NAMED_PARAMETERS");

    /**
     * Defines the remoting type for spring services.
     */
    public static final String TAGGEDVALUE_SPRING_SERVICE_REMOTING_TYPE = profile.get("SPRING_SERVICE_REMOTING_TYPE");

    /**
     * Defines the remote port for spring services.
     */
    public static final String TAGGEDVALUE_SPRING_SERVICE_REMOTE_PORT = profile.get("SPRING_SERVICE_REMOTE_PORT");

    /**
     * Define additional spring interceptors
     */
    public static final String TAGGEDVALUE_SPRING_SERVICE_INTERCEPTORS = profile.get("SPRING_SERVICE_INTERCEPTORS");

    /**
     * Define whether we will render only the configuration, but not the service itself.
     */
    public static final String TAGGEDVALUE_SERVICE_CONFIG_ONLY = profile.get("SPRING_SERVICE_CONFIG_ONLY");

    /* ----------------- Tagged Value Values ------------- */

    /**
     * the default web flow exception type
     */
    public static final String TAGGEDVALUE_WEB_FLOW_DEFAULT_EXCEPTION_TYPE = "java.lang.Exception";

    /**
     * The "like" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_LIKE = profile.get("LIKE_COMPARATOR");

    /**
     * The "case insensitive like" comparator.
     */
    public static final String TAGGEDVALUEVALUE_INSENSITIVE_LIKE_COMPARATOR =
        profile.get("INSENSITIVE_LIKE_COMPARATOR");

    /**
     * The "equals" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_EQUAL = profile.get("EQUAL_COMPARATOR");

    /**
     * The "greater of even" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_GREATER_OR_EQUAL =
        profile.get("GREATER_THAN_OR_EQUAL_COMPARATOR");

    /**
     * The "greater" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_GREATER = profile.get("GREATER_THAN_COMPARATOR");

    /**
     * The "less of even" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_LESS_OR_EQUAL = profile.get("LESS_THAN_OR_EQUAL_COMPARATOR");

    /**
     * The "less" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_LESS = profile.get("LESS_THAN_COMPARATOR");

    /**
     * The "in" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_IN = profile.get("IN_COMPARATOR");

    /**
     * The "not equal" comparator.
     */
    public static final String TAGGEDVALUEVALUE_COMPARATOR_NOT_EQUAL = profile.get("NOT_EQUAL_COMPARATOR");

    /**
     * The {@link net.sf.hibernate.expression.MatchMode#ANYWHERE} match mode.
     */
    public static final String TAGGEDVALUEVALUE_MATCHMODE_ANYWHERE = profile.get("MATCHMODE_ANYWHERE");

    /**
     * The {@link net.sf.hibernate.expression.MatchMode#END} match mode.
     */
    public static final String TAGGEDVALUEVALUE_MATCHMODE_END = profile.get("MATCHMODE_END");

    /**
     * The {@link net.sf.hibernate.expression.MatchMode#EXACT} match mode.
     */
    public static final String TAGGEDVALUEVALUE_MATCHMODE_EXACT = profile.get("MATCHMODE_EXACT");

    /**
     * The {@link net.sf.hibernate.expression.MatchMode#START} match mode.
     */
    public static final String TAGGEDVALUEVALUE_MATCHMODE_START = profile.get("MATCHMODE_START");

    /**
     * Ascending sort order.
     */
    public static final String TAGGEDVALUEVALUE_ORDER_ASCENDING = profile.get("ORDER_ASCENDING");

    /**
     * Descending sort order.
     */
    public static final String TAGGEDVALUEVALUE_ORDER_DESCENDING = profile.get("ORDER_DESCENDING");

    /**
     * Credit card.
     */
    public static final String TAGGEDVALUEVALUE_CREDIT_CARD = profile.get("CREDIT_CARD");

    /**
     * Email.
     */
    public static final String TAGGEDVALUEVALUE_EMAIL = profile.get("EMAIL");

    /**
     * URL.
     */
    public static final String TAGGEDVALUEVALUE_URL = profile.get("URL");

    /**
     * Regular expression.
     */
    public static final String TAGGEDVALUEVALUE_REGULAR_EXPRESSION = profile.get("REGULAR_EXPRESSION");

    /**
     * Range.
     */
    public static final String TAGGEDVALUEVALUE_RANGE = profile.get("RANGE");

    /**
     * <p/>
     * Represents a web service. Stereotype a class with this stereotype when you want everything on the class to be
     * exposed as a web service. </p>
     */
    public static final java.lang.String STEREOTYPE_WEBSERVICE = profile.get("WEBSERVICE");

    /**
     * <p/>
     * Stereotype an operation on a <code>service</code> if you wish to expose the operation. </p>
     */
    public static final java.lang.String STEREOTYPE_WEBSERVICE_OPERATION = profile.get("WEBSERVICE_OPERATION");

}