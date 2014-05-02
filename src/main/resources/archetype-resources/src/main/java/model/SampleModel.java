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
	private Time inTime;
    private Time outTime;
    
    @Column(name="clockin_date")
    private Date date;
    
    
    public Date getDate() {
    	return date;
    }
}