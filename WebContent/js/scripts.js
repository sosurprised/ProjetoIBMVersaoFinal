//webkitURL é legado 
URL = window.URL || window.webkitURL;
// stream é criado a partir getUserMedia()
var gumStream;
// Objeto do Record.js
var rec;
// MediaStreamAudioSourceNode
var input;
// criar novo AudioContext
var AudioContext = window.AudioContext || window.webkitAudioContext; // Classe
var audioContext; // objeto
// selecionar os botoes

function createFirstBotMessage(){
	var chat = document.querySelector("#chat_container");
	var div = createDiv("Olá, meu nome é LevelAI! Estou aqui para te ajudar a resolver suas dúvidas", "bot");
	chat.appendChild(div);
	scrollDivDown(chat);
}

/*function toggleClass(){
    var iframe_content = document.querySelector(".iframe_wrapper");
    if(iframe_content != null){
	    iframe_content.classList.add("activate");
	    iframe_content.addEventListener("click", function(e){
	        iframe_content.classList.remove("activate");
	        createFirstBotMessage();
	        
	    });    	
    }
}
*/
function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

function createDiv(text, type) {
	var div = document.createElement("div");
	div.classList.add("chat-message");
	div.classList.add(type);
	div.textContent = text;
	return div;
}

function enviarMensagemEnter(e){
	if(e.keyCode == 13){
		var mensagem = document.querySelector("#question");
		if(mensagem.value.length<1){
		alert("Digite alguma coisa.")	
		}else{
			createMessage(mensagem.value, "me");
			callBot(mensagem.value);
			mensagem.value = "";	
		}
	}
}

function enviarMensagem(){
	var mensagem = document.querySelector("#question");
	if(mensagem.value.length<1){
		alert("Digite alguma coisa.")	
	}else{
	createMessage(mensagem.value, "me");
	callBot(mensagem.value);
	mensagem.value = "";
	}
}

function createMessage(message, type){
	var chat = document.querySelector("#chat_container");
	var div = createDiv(message, type);
	chat.appendChild(div);
	scrollDivDown(chat);

}


function callBot(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "v1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var respostas = JSON.parse(xhr.responseText);
			respostas.forEach(function(resposta) {
				createMessage(resposta, "bot");
			});
		}else{
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	var data = "question=" + msg;
	xhr.send(data);
}

var btnRecord = document.querySelector("#recordButton");
var btnStop = document.querySelector("#stopButton");

btnRecord.addEventListener("click", function(event) {
	event.preventDefault();
	constraints = {
			audio : true,
			video : false
	}
	
	btnRecord.disabled = true;
	btnStop.disabled = false;
	
	navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
		audioContext = new AudioContext;
		gumStream = stream;
		input = audioContext.createMediaStreamSource(stream);
		rec = new Recorder(input, {
			numChannels : 1
		});
		rec.record();
	}).catch(function(err){
		console.log(err);
		btnRecord.disabled = false;
		btnStop.disabled = true;
	});
});


btnStop.addEventListener("click", function(event) {
	event.preventDefault();
	btnRecord.disabled = false;
	btnStop.disabled = true;	
	rec.stop();
	gumStream.getAudioTracks()[0].stop();
	rec.exportWAV(generateBlob);
});

function generateBlob(blob) {
	createAudioElement(blob);
	sendBlobToText(blob);
}
/*
function gravar() {
	var btnRecord = document.querySelector("#recordButton");
	var btnStop = document.querySelector("#stopButton");
	btnRecord.style.display = "none";
	btnStop.style.display = "block";
	constraints = {
			audio : true,
			video : false
	}	
	navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
	audioContext = new AudioContext;
	gumStream = stream;
	rec = new Recorder(input, {
		numChannels : 1
	});
	rec.record();
	})
}

function pararEnviar() {
	var btnRecord = document.querySelector("#recordButton");
	var btnStop = document.querySelector("#stopButton");
	btnRecord.style.display = "block";
	btnStop.style.display = "none";
	rec.stop();
	gumStream.getAudioTracks()[0].stop();
	rec.exportWAV(generateBlob);
	var question = document.querySelector("#question");
	sendMessageToVoice(question.value);
	question.value = "";
}

function generateBlob(blob) {
	createAudioElement(blob);
	sendBlobToText(blob);
}
*/
function sendBlobToText(blob) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "stt", true);
	xhr.setRequestHeader("Content-type", "audio/wav");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Deu bom
			var resposta = JSON.parse(xhr.responseText);
			resposta[0].alternatives.forEach(function(tran) {
				createMessage(tran.tran, "me");
			});
		} else {
			// Deu ruim
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.send(blob);
}


function sendMessageToVoice(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "tts", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var blob = new Blob([xhr.response], {type : "audio/wav"});
			createAudioElement(blob);
		}else{
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.responseType = 'blob';
	var data = "question=" + msg;
	xhr.send(data);
}

function createAudioElement(blob) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	
	audio.controls = true;
	audio.src = url;
	
	div.appendChild(audio);
	var chat = document.querySelector("#chat_container");
	chat.appendChild(div);
	scrollDivDown(chat);
}
