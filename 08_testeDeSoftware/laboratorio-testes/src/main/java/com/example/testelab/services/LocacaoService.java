package com.example.testelab.services;

import java.time.LocalDate;
import java.util.List;

import com.example.testelab.models.Filme;
import com.example.testelab.models.Locacao;
import com.example.testelab.models.Usuario;
import com.example.testelab.utils.DataUtils;

public class LocacaoService {
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws Exception{
		for(Filme filme : filmes){
			if(filme.getEstoque() == 0){
				throw new RuntimeException("Fime sem estoque");
			}
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(LocalDate.now());

		Double valor = 0d;
		for(Filme filme : filmes){
			valor += filme.getPrecoLocacao();
		}
		locacao.setValor(valor);

		// Entrega no dia seguinte
		LocalDate dataEntrega = DataUtils.adicionarDias(LocalDate.now(), 1);

		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar método para salvar no banco de dados

		return locacao;
	}

	// public static void main(String[] args) throws Exception {
	// 	LocacaoService service = new LocacaoService();
	// 	Usuario user = new Usuario("Lia");
	// 	Filme film = new Filme("Homem-Aranha 2", 5, 3.50);

	// 	Locacao locacao = service.alugarFilme(user, film);

	// 	// verificação
	// 	System.out.println(locacao.getValor() == 3.50);
	// 	System.out.println(locacao.getFilme().getEstoque() == 5);
	// 	System.out.println(locacao.getDataRetorno() == DataUtils.obterDataComDiferencaDias(1));
	// }
}