#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )


import javax.persistence.MappedSuperclass;

/**
 * The Class AbstractEntity.
 */
@MappedSuperclass
public abstract class AbstractEntity
{

    /**
     * The current implementation makes a loose check for class equivalence. We cannot make a simple
     * class equality check as CGLIB creates a proxy class with a difference name. Because of the
     * proxy class, we need to prevent referring directly to non final fields from final methods and
     * use getters instead.
     * 
     * @param other
     *            Object to compare to
     * @return true if objects are equal
     */
    @Override
    public boolean equals(final Object other)
    {
        if (super.equals(other))
        {
            return true;
        }

        if (other != null && other instanceof AbstractEntity)
        {
            AbstractEntity entity = (AbstractEntity) other;
            Object otherId = entity.getId();
            Object thisId = this.getId();

            if (other.getClass().isAssignableFrom(this.getClass())
                    || this.getClass().isAssignableFrom(other.getClass()))
            {
                return otherId != null && otherId.equals(thisId);
            }
        }

        return false;
    }

    public abstract Object getId();

    /**
     * Hash code.
     * 
     * @return HashCode according to the UUID
     * @see java.lang.Object${symbol_pound}hashCode()
     */
    @Override
    public int hashCode()
    {
        return getId() == null ? super.hashCode() : getId().hashCode();
    }

    /**
     * To string.
     * 
     * @return String description of the Entity
     * @see java.lang.Object${symbol_pound}toString()
     */
    @Override
    public String toString()
    {
        return new StringBuffer().append('[').append(getClass().getName()).append(' ').append(getId()).append(']')
                .toString();
    }

}