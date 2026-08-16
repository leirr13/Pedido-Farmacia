# Pedido de Medicación – Android

App offline para realizar pedidos semanales de medicación.

## Funciones
- Listado inicial de medicamentos basado en las hojas facilitadas.
- Búsqueda.
- Cantidad a pedir por medicamento, guardada en el teléfono.
- Generación de pedido solo con cantidades > 0.
- Copiar, compartir y generar PDF.
- Mantén pulsado el nombre de un medicamento para editar **nombre, stock mínimo y unidad**.
- Botón **AÑADIR** para incorporar nuevos medicamentos y elegir apartado.
- Los cambios del listado se conservan en la instalación actual.

## Compilar sin Android Studio
El proyecto incluye un workflow de GitHub Actions. Puedes subir esta carpeta a un repositorio de GitHub y ejecutar:
**Actions → Compilar APK → Run workflow**.
El APK aparecerá como artefacto descargable llamado `PedidoMedicacion-debug`.

También puedes compilar localmente con Gradle 8.7 y JDK 17:
`gradle assembleDebug`

El APK se genera en:
`app/build/outputs/apk/debug/app-debug.apk`
