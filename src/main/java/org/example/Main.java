package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bd_jpa_jogador_h2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        cadastrarJogadores(entityManager);

        List<Jogador> jogadores = recuperarJogadores(entityManager);
        imprimirDadosJogadores(jogadores);

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void cadastrarJogadores(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Jogador jogador1 = new Jogador("Jogador1", "Atirador", "mibr", "Ouro");
        Jogador jogador2 = new Jogador("Jogador2", "Suporte", "Fnatic", "Prata");
        Jogador jogador3 = new Jogador("Jogador3", "Topo", "Cloud9", "Diamante");

        entityManager.persist(jogador1);
        entityManager.persist(jogador2);
        entityManager.persist(jogador3);

        transaction.commit();
    }

    private static List<Jogador> recuperarJogadores(EntityManager entityManager) {
        TypedQuery<Jogador> query = entityManager.createQuery("SELECT j FROM Jogador j", Jogador.class);

        // Executando a consulta
        return query.getResultList();
    }

    private static void imprimirDadosJogadores(List<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            System.out.println("ID: " + jogador.getId());
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Função: " + jogador.getFuncao());
            System.out.println("Time: " + jogador.getNomeTime());
            System.out.println("Patente: " + jogador.getPatente());
            System.out.println();
        }
    }
}
