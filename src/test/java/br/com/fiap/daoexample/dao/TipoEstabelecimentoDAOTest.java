package br.com.fiap.daoexample.dao;

import br.com.fiap.daoexample.cfg.HibernateUtil;
import br.com.fiap.daoexample.domain.Avaliacao;
import br.com.fiap.daoexample.domain.TipoEstabelecimento;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;

public class TipoEstabelecimentoDAOTest {

    private static EntityManager em;

    @BeforeAll
    public static void setup() {
        em = HibernateUtil.getEntityManager();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (em != null) em.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test()
    @DisplayName("dado um tipo de estabelecimento, quando tenta gravar , deve recuperar o tipo de estabelecimento no banco")
    public void cadastrarBuscar() {
        TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
        TipoEstabelecimento tipo = new TipoEstabelecimento();
        tipo.setNome("Bar e Restaurante");
        dao.cadastrar(tipo);
        try {
            dao.commit();
            TipoEstabelecimento inserted = dao.buscar(1);
            Assertions.assertEquals(tipo.getNome(), inserted.getNome());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test()
    @DisplayName("dado um tipo de estabelecimento, quando tenta remover , deve remover o tipo de estabelecimento no banco")
    public void cadastrarDeletarBuscar() {
        TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
        TipoEstabelecimento tipo = new TipoEstabelecimento();
        tipo.setNome("Bar e Restaurante");
        dao.cadastrar(tipo);
        try {
            dao.commit();
            TipoEstabelecimento inserted = dao.buscar(1);
            Assertions.assertEquals(tipo.getNome(), inserted.getNome());
            dao.excluir(inserted.getId());
            TipoEstabelecimento deleted = dao.buscar(1);
            Assertions.assertNotNull(deleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
}
