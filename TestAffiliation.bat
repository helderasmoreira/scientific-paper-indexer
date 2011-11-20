@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files


set S1=Affiliation.rtf

set S2=TestAffiliation.rtf

rem "C:\Program Files (x86)\The VDM++ Toolbox Academic v8.0\bin\vppde" -p -R vdm.tc %S1% %S2%

for /R %%f in (TestAffiliation\*.arg) do call vdmtest "%%f"
