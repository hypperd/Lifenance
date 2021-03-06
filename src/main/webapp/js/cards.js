var arrayData;

function populateTable() {
    $.ajax({
        url : 'controller/card',
        type : 'GET',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(data) {
            $("#tbody").empty();
            arrayData = data;
            $(data).each(
                    function(i) {
                        $('#tbody').append(
                                '<tr><td>'
                                        +'<div class="row">'
                                        + '<div class="mx-auto">'
                                        + '<form class="delete-card">'
                                            + '<button class="btn btn-primary"><i class="fas fa-trash"></i></button>'
                                            + '<input type="hidden" name="id" value="' + data[i].id + '">'
                                        + '</form>'
                                        + '</div>'
                                        + '<div class="mx-auto">'
                                            + '<button class="btn btn-primary" onclick="edit(' + i + ')"><i class="fas fa-pen"></i></button>'
                                        + '</div>'
                                        + '</div>'
                                        + '</td><td>'
                                        + data[i].nome + '</td><td>'
                                        + data[i].number + '</td><td>'
                                        + data[i].validity + '</td><td>'
                                        + data[i].limite + '</td><td>'
                                        + data[i].multa + '</td><td>'
                                        + data[i].vencimentoFatura + '</td><td>'
                                        + data[i].cardFlag.name +
                                '</td></tr>')
            });
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}

function edit(index) {
    let data = arrayData[index];

    $('#card-id').val(data.id);
    $('#username').val(data.nome);
    $('#cardNumber').val(data.number);

    console.log(data.validity);
    
    let date = moment(data.validity, 'DD-MM-YYYY');

    let month = date.format('M');
    let year  = date.format('YYYY');

    $('#validadeMes').val(month);
    $('#validadeAno').val(year);
    
    $('#multa').val(data.multa);
    $('#limiteCartao').val(data.limite);
    populateSelect();
    $('#fatura').val(data.vencimentoFatura);
    $('#form-modal').modal('show');

    $("#card-register").submit(function(event) {
        event.preventDefault();

        let form = $(this);
        let actionUrl = 'controller/card/edit';

        $.ajax({
            type: "POST",
            url: actionUrl,
            data: form.serialize(),
            success: function(data) {

                if (data.error == true) {
                    $('#modal-title').text('Erro!');
                } else {
                    $('#form-modal').modal('hide');
                    $('#error-modal').modal('show');
                    $('#modal-title').text('Sucesso!');
                    $('#modal-text').text(data.text);
                    $("#modal-close").click(function(){
                        populateTable();
                    });
                }
            }
        });
    });
}

$(document).ready(populateTable());

$(document).on('submit', '.delete-card', function(event) {
    event.preventDefault();

    let form = $(this);

    $.ajax({
        type: "POST",
        url: 'controller/card/delete',
        data: form.serialize(),
        success: function(data) {

            $('#error-modal').modal('show');

            if (data.error == true) {
                $('#modal-title').text('Erro!');
                $('#modal-text').text(data.text);
            } else {
                $('#modal-title').text('Sucesso!');
                $('#modal-text').text(data.text);
                $("#modal-close").click(function(){
                    populateTable();
                });

            }

        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
});