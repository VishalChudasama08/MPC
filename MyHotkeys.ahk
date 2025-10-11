#NoTrayIcon           ; hides the tray icon (optional)
#SingleInstance Force ; prevents duplicate runs

; --- WhatsApp [win+w] ---
#W::Run "explorer.exe shell:AppsFolder\5319275A.WhatsAppDesktop_cv1g1gvanyjgm!App"

; --- Chrome [win+b] ---
#B::Run "C:\Program Files\Google\Chrome\Application\chrome.exe"

; --- Task Manager [win+t] ---
#T::Run "taskmgr.exe"

; --- Paint [win+p] ---
#P::Run "mspaint.exe"

; --- VS Code [win+c] ---
#C::Run "C:\Users\visha\AppData\Local\Programs\Microsoft VS Code\Code.exe"

Return
