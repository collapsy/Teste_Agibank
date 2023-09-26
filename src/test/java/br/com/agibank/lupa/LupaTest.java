package br.com.agibank.lupa;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LupaTest {
    private LupaPage paginaLupa;

    @BeforeEach
    public void beforeEach(){
        this.paginaLupa = new LupaPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaLupa.fechar();
    }

    @Test
    public void pesquisaComSucesso(){
        this.paginaLupa.pesquisarPalavraNoBlog("teste");

        Assert.assertTrue(this.paginaLupa.isPaginaAtual());
        Assert.assertTrue(this.paginaLupa.isPalavraVisivel());
        Assert.assertEquals(this.paginaLupa.resutadoDaBuscaPor(),"Resultados da busca por: teste");
    }

    @Test
    public void pesquisaNenhumResutado(){
        this.paginaLupa.pesquisarPalavraNoBlog("gsdgdfgdf");

        Assert.assertTrue(this.paginaLupa.isPaginaAtual());
        Assert.assertTrue(this.paginaLupa.isPalavraVisivel());
        Assert.assertEquals(this.paginaLupa.resutadoDaBuscaPor(),"Nenhum resultado");
    }
}
