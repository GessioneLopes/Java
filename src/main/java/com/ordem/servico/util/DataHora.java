package com.ordem.servico.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHora {

    public String hora;
    public String data;

    private SimpleDateFormat horaFormatada;
    private SimpleDateFormat dataFormatada;

    public DataHora() {
        horaFormatada = new SimpleDateFormat("HH:mm:ss");
        dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String ler_hora() {
        Date horaAtual = new Date();
        hora = horaFormatada.format(horaAtual);
        return hora;
    }

    public String ler_Data() {
        Date dataAtual = new Date();
        data = dataFormatada.format(dataAtual);
        return data;
    }

}
