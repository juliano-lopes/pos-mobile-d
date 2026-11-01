# MarcianoApp — Programação Orientada a Objetos no Android com Kotlin

Aplicativo Android nativo desenvolvido em **Kotlin** durante a Especialização em Desenvolvimento Web e Mobile no **Instituto Federal do Sudeste de Minas Gerais (IF Sudeste MG)**.

O projeto implementa o robô interativo **Marciano**, demonstrando na prática a evolução de uma arquitetura baseada nos pilares de **Programação Orientada a Objetos (POO)** integrada ao ciclo de vida de múltiplas *Activities* no Android.

---

## Arquitetura e Pilares de POO Aplicados

- **`Marciano.kt` (Classe Base):** Implementa a lógica fundamental de interpretação de comandos de texto (perguntas, gritos, ordens e respostas padrão).
- **`MarcianoAvancado.kt` (Herança e Sobrescrita):** Estende `Marciano` adicionando capacidade de processamento de operações matemáticas (`some`, `subtraia`, `multiplique`, `divida`).
- **`MarcianoPremium.kt` (Polimorfismo e Interfaces):** Estende `MarcianoAvancado` recebendo implementações da interface funcional `AcaoUsuario` (como `AcaoContagemRegressiva.kt`) para executar comportamentos customizados.
- **Camada de Interface (UI):**
  - `MainActivity.kt` e `EscolhaRoboActivity.kt`: Seleção do nível do robô e envio de mensagens;
  - `RespostaActivity.kt` e `MessageAdapter.kt`: Exibição do histórico de interação em lista otimizada.

---

## Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **Plataforma:** Android SDK (Gradle Kotlin DSL)
- **Testes:** JUnit e Testes Instrumentados Android (`ExampleInstrumentedTest.kt`)

---

## Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/juliano-lopes/pos-mobile-d.git
   ```
2. Abra a pasta do projeto no **Android Studio**.
3. Aguarde a sincronização do **Gradle** e execute o aplicativo em um emulador ou dispositivo físico Android.

---

## Autor

Desenvolvido por **[Juliano Lopes](https://julianolopes.com.br)**.
