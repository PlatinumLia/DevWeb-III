package com.example.testelab.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Locacao {
	private Usuario usuario;
	private List<Filme> filmes = new ArrayList<>();
	private LocalDate dataLocacao;
	private LocalDate dataRetorno;
	private Double valor;

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public LocalDate getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<Filme> getFilme() {
		return filmes;
	}
	public void setFilme(List<Filme> filmes) {
		this.filmes = filmes;
	}
}