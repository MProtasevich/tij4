@echo off

if %2 GTR 9 (
  for /L %%i in (1, 1, 9) do mkdir "%1\ex0%%i"
  for /L %%i in (10, 1, %2) do mkdir "%1\ex%%i"
) else (
  for /L %%i in (1, 1, %2) do mkdir "%1\ex0%%i"
)