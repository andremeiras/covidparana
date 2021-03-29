package br.com.andremeiras.covidparana.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import br.com.andremeiras.covidparana.model.CasosEObitos;

@Service
public class CovidParanaServices {

    // Inicialmente apenas do dia 28/03/2021
    private static String URL = "https://www.saude.pr.gov.br/sites/default/arquivos_restritos/files/documento/2021-03/informe_epidemiologico_28_03_2021_obitos_casos_municipio.csv";

    private List<CasosEObitos> listaCasosEObitos = new ArrayList<>();

    @PostConstruct
    public void fetchCasosEObitos() throws IOException, InterruptedException {
        List<CasosEObitos> novaListaCasosEObitos = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            CasosEObitos casosEObitos = new CasosEObitos();
            casosEObitos.setMunicipio(record.get("municipio"));
            casosEObitos.setRs(record.get("rs"));

            int qtdeCasos = Integer.parseInt(record.get(record.size()));
            int qtdeObitos = Integer.parseInt(record.get(record.size()));
            int qtdeRecuperados = Integer.parseInt(record.get(record.size()));

            casosEObitos.setQtdeCasos(qtdeCasos);
            casosEObitos.setQtdeObitos(qtdeObitos);
            casosEObitos.setQtdeRecuperados(qtdeRecuperados);

            novaListaCasosEObitos.add(casosEObitos);
        }
        this.listaCasosEObitos = novaListaCasosEObitos;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String uRL) {
        URL = uRL;
    }

    public List<CasosEObitos> getListaCasosEObitos() {
        return listaCasosEObitos;
    }

    public void setListaCasosEObitos(List<CasosEObitos> listaCasosEObitos) {
        this.listaCasosEObitos = listaCasosEObitos;
    }
}
