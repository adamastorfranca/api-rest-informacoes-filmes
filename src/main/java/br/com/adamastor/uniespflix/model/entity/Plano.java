package br.com.adamastor.uniespflix.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Table(name = "PLANOS")
@Data
public class Plano implements GrantedAuthority{

	private static final long serialVersionUID = 22755313226487489L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PLANO")
	private Long id;
	
	@Column(name = "DS_NOME", nullable = false)
	private String nome;
	
	@Column(name = "DS_PLANO", nullable = false)
	private String descricao;

	@Column(name = "NU_VALOR", nullable = false)
	private BigDecimal valor;
	
	
	@Override
	public String getAuthority() {
		return this.nome;
	}

}
