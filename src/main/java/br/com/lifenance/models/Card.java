package br.com.lifenance.models;

import br.com.lifenance.models.annotations.ColumnName;
import br.com.lifenance.models.annotations.PrimaryKey;

import java.time.LocalDate;

public class Card {

    @PrimaryKey("card_id")
    private long id;
    @ColumnName("card_name")
    private String nome;
    @ColumnName("card_number")
    private long number;
    @ColumnName("validity")
    private LocalDate validity;
    @ColumnName("limite")
    private float limite;
    @ColumnName("multa")
    private int multa;
    @ColumnName("vencimento_fatura")
    private int vencimentoFatura;
    @ColumnName("card_flag_id")
    private CardFlag cardFlag;
    @ColumnName("user_cpf")
    private User user;

    public Card(long id, long number, LocalDate validity, CardFlag cardFlag, int multa, float limite,
                int vencimentoFatura, String nome, User user) {
        this.id = id;
        this.number = number;
        this.validity = validity;
        this.cardFlag = cardFlag;
        this.multa = multa;
        this.limite = limite;
        this.vencimentoFatura = vencimentoFatura;
        this.nome = nome;
        this.user = user;
    }

    public Card(long number, LocalDate validity, CardFlag cardFlag, int multa, float limite,
                int vencimentoFatura, String nome, User user) {
        this.number = number;
        this.validity = validity;
        this.cardFlag = cardFlag;
        this.multa = multa;
        this.limite = limite;
        this.vencimentoFatura = vencimentoFatura;
        this.nome = nome;
        this.user = user;
    }

    // Constructor for genericDAO
    public Card(String arg) {
        String[] split = arg.split(";");
        System.out.println(arg);
        this.id = Long.parseLong(split[0]);
        this.nome = split[1];
        this.number = Long.parseLong(split[2]);
        this.validity = LocalDate.parse(split[3]);
        this.limite = Float.parseFloat(split[4]);
        this.multa = Integer.parseInt(split[5]);
        this.cardFlag = ModelFactory.getModel(CardFlag.class, "card_flags", Long.parseLong(split[6]));
        this.user = ModelFactory.getModel(User.class, "users", split[7]);
        this.vencimentoFatura = Integer.parseInt(split[8]);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public CardFlag getFlag() {
        return cardFlag;
    }

    public void setFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public int getVencimentoFatura() {
        return vencimentoFatura;
    }

    public void setVencimentoFatura(int vencimentoFatura) {
        this.vencimentoFatura = vencimentoFatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public void setCardFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", number=" + number +
                ", validity=" + validity +
                ", limite=" + limite +
                ", multa=" + multa +
                ", vencimentoFatura=" + vencimentoFatura +
                ", cardFlag=" + cardFlag +
                ", user=" + user +
                '}';
    }
}

