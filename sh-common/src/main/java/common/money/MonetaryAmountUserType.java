package common.money;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import common.repository.ImmutableValueUserType;

/**
 * A Hibernate user type for the MonetaryAmount type. This class enables Hibernate to map a MonetaryAmount object to and
 * from a double column type in a database.
 * @see MonetaryAmount
 */
public class MonetaryAmountUserType extends ImmutableValueUserType {

	public Class returnedClass() {
		return MonetaryAmount.class;
	}

	public int[] sqlTypes() {
		return new int[] { Types.NUMERIC };
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		BigDecimal value = rs.getBigDecimal(names[0]);
		if (value == null) {
			return null;
		} else {
			return new MonetaryAmount(value);
		}
	}

	public void nullSafeSet(PreparedStatement ps, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			ps.setNull(index, Types.NUMERIC);
		} else {
			MonetaryAmount amount = (MonetaryAmount) value;
			ps.setBigDecimal(index, amount.asBigDecimal());
		}
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
			SessionImplementor arg3) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
	}
}
