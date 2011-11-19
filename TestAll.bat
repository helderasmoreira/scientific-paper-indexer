@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files

set S1=Author.rtf
set S2=Interest.rtf
set S3=Affiliation.rtf
set S4=Date.rtf
set S5=Indexer.rtf
set S6=Reference.rtf
set S7=Publication.rtf


set S8=TestAuthor.rtf
set S9=TestIndexer.rtf

"C:\Program Files (x86)\The VDM++ Toolbox Academic v8.0\bin\vppde" -p -R vdm.tc %S1% %S2% %S3% %S4% %S5% %S6% %S7% %S8% %S9%

for /R %%f in (TestAuthor\*.arg) do call vdmtest "%%f"
for /R %%f in (TestIndexer\*.arg) do call vdmtest "%%f"
