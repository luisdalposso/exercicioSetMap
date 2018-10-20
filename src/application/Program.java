package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votacao = new LinkedHashMap<>();

		System.out.print("entre com o caminho completo: ");
		String caminho = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			String linha = br.readLine();
			while (linha != null) {

				String[] campos = linha.split(",");
				String candidato = campos[0];
				int votos = Integer.parseInt(campos[1]);

				if (votacao.containsKey(candidato)) {
					int votosParciais = votacao.get(candidato);
					votacao.put(candidato, votos + votosParciais);
				} else {
					votacao.put(candidato, votos);
				}

				linha = br.readLine();
			}

			for (String key : votacao.keySet()) {
				System.out.println(key + ": " + votacao.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}