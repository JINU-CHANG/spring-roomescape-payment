### 프로젝트 소개

- 우아한테크코스 레벨 2단계 레포지토리입니다.
- 방탈출 예약을 관리할 수 있는 웹 애플리케이션을 구현합니다.
- 주요 기능으로는 `방탈출 예약 및 대기 기능`, `결제 기능`, `어드민 예약 관리 기능`이 있습니다.
- 요구사항에 따른 웹 애플리케이션 구현과 스프링 프레임워크 학습을 목표로 합니다.

### 프로젝트 PR

코드를 구현하며 고민했던 내용 및 리뷰어와 소통한 내용이 정리되어 있습니다. 자세한 내용은 아래에서 확인 가능합니다.

| 🏠 방 탈출 예약 관리 Step1 - 3 | [PR-66](https://github.com/woowacourse/spring-roomescape-admin/pull/66) |
| --- | --- |
| 🏠 방 탈출 예약 관리 Step4 - 6 | [PR-93](https://github.com/woowacourse/spring-roomescape-admin/pull/93) |
| 🏠 방 탈출 예약 관리 Step7 - 9 | [PR - 182](https://github.com/woowacourse/spring-roomescape-admin/pull/182) |
| 📒 방탈출 사용자 예약 Step1 - 3 | [PR-34](https://github.com/woowacourse/spring-roomescape-member/pull/34) |
| 📒 방탈출 사용자 예약 Step4 - 6 | [PR-108](https://github.com/woowacourse/spring-roomescape-member/pull/108) |
| 💸 방 탈출 결제 배포 Step1 | [PR-71](https://github.com/woowacourse/spring-roomescape-payment/pull/71) |
| 💸 방 탈출 결제 배포 Step2-4 | [PR-117](https://github.com/woowacourse/spring-roomescape-payment/pull/117) |

### 사용자 예약 및 대기 기능
- [x] 날짜, 테마, 시간을 선택하여 예약을 생성할 수 있습니다.
- [x] 해당 시간에 이미 생성된 예약이 있다면 대기할 수 있습니다.
- [x] 생성된 예약은 내 예약 페이지에서 확인 가능합니다.
<img width="800" height="800" alt="image" src="https://github.com/user-attachments/assets/9ac15037-785e-45e1-919f-51817904e3c1" />
<img width="800" height="800" alt="image" src="https://github.com/user-attachments/assets/b1f66b7c-e8cc-4940-b179-e2ea10c15c0a" />

### 결제 기능
- [x] 결제 기능은 외부의 결제 서비스 API를 활용하여 연동합니다.
- [x] 결제 취소 시 예약이 취소됩니다.
<img width="800" height="800" alt="image" src="https://github.com/user-attachments/assets/95f5c315-bae9-45e0-87b8-0da5388564ba" />
<img width="800" height="800" alt="스크린샷 2025-12-27 오후 8 31 41" src="https://github.com/user-attachments/assets/3953671d-e9f7-497e-831e-1761cecb38be" />

### 어드민 예약 관리 기능
- [x] 어드민은 예약 대기를 승인 혹은 거절할 수 있습니다.
<img width="800" height="800" alt="image" src="https://github.com/user-attachments/assets/c681e64f-b57f-454f-8cf0-89c6096bb816" />
