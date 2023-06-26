# テストの現状
## library
### 単体テスト
- domain
  - 一部のテストあり　https://github.com/system-sekkei/library/tree/master/src/test/java/library/domain/model/loan
  - ロジックのあるクラスのテストがない（Loanability, Restriction, ReservationRestriction）
  - ロジックを実装していないクラスのテストはない（作らない）
  - コレクションのテストがない

### 統合テスト
- application
  - scenario, service の一部(半分)程度
- infrastructure
  - datasourceのテストの実装例として記述？
- controller
  - コントローラーのテストの実装例として記述（サンプル？）

- 他アプリケーションのmockを使ったテストはない 

### E2E テスト
- なし
- seleniumやcypress？
- karate?

### NOTE
- validationのテスト
- 「単体テスト、統合テスト、E2Eテストの順にテストケース数は少なくなる」にはなっていない
- 単体テストではできるだけ多くの異常ケース、統合テストでは1件のハッピーパス、単体テストで扱えなかった異常ケース => 異常ケースの扱い


## 分散アプリケーション
### 単体テスト
- なし

### E2E テスト
- karate

### NOTE 
業務ロジックがほとんどないので、単体テストは少ないまたはない