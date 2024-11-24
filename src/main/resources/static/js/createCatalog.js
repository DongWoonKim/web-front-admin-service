$(document).ready(() => {
    $('#catalogCreate').click(() => {

        let isbn = $('#isbn').val();
        let author = $('#author').val();
        let price = $('#price').val();

        console.log('res 1 :: ', isbn);
        console.log('res 2 :: ', author);
        console.log('res 3 :: ', price);

    });
});