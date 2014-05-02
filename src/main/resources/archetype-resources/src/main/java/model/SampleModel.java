#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.stmicro.eot.persistence.AbstractGeneratedIdEntity;

@Entity
public class SampleModel extends AbstractGeneratedIdEntity
{
	private static final long serialVersionUID = 1L;
    
    @Column(name="sample_date")
    private Date date;
    
    
    public Date getDate() {
    	return date;
    }
    
    public void setDate(Date date) {
    	this.date = date;
    }
}
