#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )


import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Provides a base class from which to extend persistent entity classes.
 */
@MappedSuperclass
public abstract class AbstractGeneratedIdEntity extends AbstractEntity implements Serializable
{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * @see com.sportsvilla.persistence.AbstractEntity${symbol_pound}getId()
     */
    @Override
    public final Long getId()
    {
        return id;
    }
    
    /**
     * (non-Javadoc)
     * @see com.sportsvilla.persistence.AbstractEntity${symbol_pound}setId(java.lang.Long)
     */
    public final void setId(final Long id)
    {
        this.id = id;
    }

}