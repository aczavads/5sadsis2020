package springBootApp.pagamento;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pagamento {
	@Id
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date pagoEm;
		
	private BigDecimal valor;

	
	
	public Pagamento(Long id, Date pagoEm, BigDecimal valor) {
		super();
		this.id = id;
		this.pagoEm = pagoEm;
		this.valor = valor;
	}

	public Pagamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPagoEm() {
		return pagoEm;
	}

	public void setPagoEm(Date pagoEm) {
		this.pagoEm = pagoEm;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
