var stompDataClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var dataSocket = new SockJS('/exchange-data-websocket');
    stompDataClient = Stomp.over(dataSocket);
    stompDataClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompDataClient.subscribe('/topic/fxrates', function (greeting) {
            var json = JSON.parse(greeting.body);
            var primaryCurrency = json.fxRate.currencyPair.primaryCurrency.value;
            var secondaryCurrency = json.fxRate.currencyPair.secondaryCurrency.value;
            var fxRate = json.fxRate.rate.value;
            var brokerName = json.broker.brokerName.value;
            var brokerCode = json.broker.brokerCode.value;
            showGreeting(brokerCode + "(" + brokerName + ") " + primaryCurrency + "/" + secondaryCurrency + " " + fxRate);
        });
    });
}

//{"broker":{"brokerName":{"value":"Barclays"},"brokerCode":{"value":"BARC"}},"fxRate":{"currencyPair":{"primaryCurrency":{"value":"JPY"},"secondaryCurrency":{"value":"USD"}},"rate":{"value":99.120581}}}
function disconnect() {
    if (stompDataClient !== null) {
        stompDataClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    var primaryCurrency = $("#currencyPair").val().slice(0,3);
    var secondaryCurrency = $("#currencyPair").val().slice(3,6);
    stompDataClient.send("/app/getRate", {}, JSON.stringify({'primaryCurrency': primaryCurrency, 'secondaryCurrency': secondaryCurrency}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});