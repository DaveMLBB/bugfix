Creare un’applicazione che implementa le funzionalità minime per un bug tracker.

Di seguito la lista delle principali funzionalità richieste:
 ****Un utente anonimo può segnalare un bug
 Un utente anonimo può commentare un bug****
 Un utente anonimo può suggerire una fix per il bug
 Un utente amministratore può accettare una fix per il bug
Il fusso dovrà essere il seguente:
 Un utente segnala un bug
 N utenti commentano il bug
 N utenti propongono delle fix
 N amministratori accettano le fix
 Quando una fix raggiunge 3 approvazioni da parte di amministratori viene considerata come
valida
 Quando una fix viene accettata non deve essere più possibile commentare o proporre fix
 (opzionale) Quando una fix viene accettata, viene inviata una mail di riepilogo a tutti gli
amministratori
Semplificazioni:
Al fine di evitare un sistema di autenticazione, l’ utente amministratore sarà in possesso di un token
statico che gli permette essere riconosciuto (consiglio: utilizzare il token come header e valutarlo
all’ interno di un filtro/interceptor)