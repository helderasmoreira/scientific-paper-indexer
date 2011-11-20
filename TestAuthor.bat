@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files

set S1=Author.rtf
set S2=Interest.rtf
set S3=Affiliation.rtf

set S4=TestAuthor.rtf

rem "C:\Program Files (x86)\The VDM++ Toolbox Academic v8.0\bin\vppde" -p -R vdm.tc %S1% %S2% %S3% %S4%

for /R %%f in (TestAuthor\*.arg) do call vdmtest "%%f"
