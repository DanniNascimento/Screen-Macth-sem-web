package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadoSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDado;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScreenmatchApplicationTests implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro porjeto Spring sem web...");

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDado("http://www.omdbapi.com/?t=matrix&apikey=3b3c4967");
			System.out.println(json);
		ConverteDado conversor = new ConverteDado();
		DadoSerie dados = conversor.obterDado(json, DadoSerie.class);
		System.out.println(dados);
	}
}
