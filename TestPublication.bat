@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files

set S1=Author.rtf
set S2=Interest.rtf
set S3=Affiliation.rtf
set S4=Date.rtf
set S5=Reference.rtf
set S6=Publication.rtf

set S7=TestAuthor.rtf
set S8=TestAffiliation.rtf
set S9=TestInterest.rtf
set S10=TestDate.rtf
set S11=TestPublication.rtf

rem "C:\Program Files (x86)\The VDM++ Toolbox Academic v8.0\bin\vppde" -p -R vdm.tc %S1% %S2% %S3% %S4% %S5% %S6% %S7% %S8% %S9% %S10% %S11% 

for /R %%f in (TestPublication\*.arg) do call vdmtest "%%f"
