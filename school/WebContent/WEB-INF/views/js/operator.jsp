<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../global/header.jsp" />


<div class="container" style="width: 1000px; margin: 0 auto;">
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell">
			<ul class="nav nav-pills nav-stacked">
				<li class="dropdown active"><a onclick="opr.sysout()">배열출력</a></li>
				<li class="dropdown active"><a onclick="opr.score()">어벤저스</a></li>
				<li class="dropdown active"><a onclick="opr.grade()">성적계산기</a></li>
				<li class="dropdown active"><a onclick="opr.gender()">성별
						구분하기</a></li>
				<li class="dropdown active"><a onclick="opr.bigNum()">최대 값</a></li>
				<li class="dropdown active"><a onclick="opr.gugudan()">구구단</a></li>
				<li class="dropdown active"><a onclick="opr.sum1to100()">1to100</a></li>
				<li class="dropdown active"><a onclick="opr.oddSum()">oddSum</a></li>
			</ul>
		</div>
		<div class="col-xs-12 col-sm-8 display-cell" id="result"
			style="border: 1px solid black; height: 500px">text</div>
	</div>
</div>


<script type="text/javascript">
	var opr = {
		sysout : function() {

			var arr = [ '사과', '배', '감', '귤' ];
			for ( var i in arr) {
				console.log(arr[i] + '\t');
			}
		},
		score : function() {
			var result = '';
			var avengers = [];
			avengers.push({
				name : '아이언',
				kor : 90,
				eng : 90,
				math : 90
			});
			avengers.push({
				name : '헐크',
				kor : 80,
				eng : 80,
				math : 80
			});
			avengers.push({
				name : '캡아',
				kor : 70,
				eng : 70,
				math : 70
			});
			for ( var i in avengers) {
				avengers[i].getSum = function() {
					result = this.kor + this.eng + this.math;
					return result;
				}
				avengers[i].getAvg = function() {
					result = this.getSum() / 3;
					return result;
				}
				console
						.log('이름 :' + avengers[i].name + '합계 :'
								+ avengers[i].getSum() + '평균 : '
								+ avengers[i].getAvg());
			}
			result = '============ 어벤저스 성적표 ============ \n';
			result += '이름\t국어\t영어\t수학\t총점\t평균\n';
			result += '-------------------------------------\n';
			for ( var i in avengers) {
				{
					with (avengers[i]) {
						result += name + ':\t' + kor + ':\t' + eng + ':\t'
								+ math + ':\t' + getSum() + ':\t' + getAvg()
								+ '\n';
					}
				}
			}
			/*
			with 키워드는 배열에 담긴 하나의 객체를 의미한다.
			즉 예를 들어
			var iron = {name : '아이언',kor : 90,eng : 90,math : 90}
			이렇게 선언된 하나의 객체를 avengers.push(iron) 이라고 줄 경우
			출력문에서 with 를 사용하지 않는다면 iron.name 이런 식으로 일일히
			명시해야 하기 때문에 with 를 사용한다
			 */
			console.log('어벤저스 성적표 : ' + result);
		},
		grade : function() {
			/*
			평균 90 이상 A
			80 B
			70 C
			60 D
			미만 F
			 */
			var kor = Number(prompt('국어점수')), eng = Number(prompt('영어점수')), math = Number(prompt('수학점수'));

			var avg = (kor + eng + math) / 3;
			avg = parseInt(avg);
			console.log(avg);
			var result = '';
			if (avg < 90) {
				result = 'A';
			}
			if (avg < 80) {
				result = 'B';
			}
			if (avg < 70) {
				result = 'C';
			}
			if (avg < 60) {
				result = 'D';
			}
			if (avg < 50) {
				result = 'F';
			}
			console.log('학생의 학점은 : \t' + result + '입니다.');
			document.getElementById("result").innerHTML = "점수합계 : "
					+ (kor + eng + math) + "  학점은 : " + result;
		},
		gender : function() {
			/* 
			800101-1234567 일 경우 flag 값은 1 이다라고 정의함
			 */
			var ssn = prompt('800101-1234567 로 입력해주세요');
			var flag = ssn.charAt(7); // 라면 성별을 판별하는 로직을 switch - case 로 완성하시오
			// 자바의 switch case 와 동일
			/* 
			800101-1234567 일 경우 flag 값은 1 이다라고 정의함
			 */
			// 라면 성별을 판별하는 로직을 switch - case 로 완성하시오
			// 자바의 switch case 와 동일
			var flag = ssn.charAt(7);
			var result = '';
			switch (flag) {
			case '1':
				result = '남자';
				break;
			case '2':
				result = '여자';
				break;
			case '3':
				result = '남자';
				break;
			case '4':
				result = '여자';
				break;
			default:
				break;
			}
			document.getElementById("result").innerHTML = "입력한 주민번호 성별  : "
					+ flag + ": " + result;
		},
		bigNum : function() {
			/* 80, 70, 60 일 경우 if 문으로 최대값 을 구하는 로직을 완성하시오 */
			var arr = [ 80, 70, 60 ];
			var max = arr[1];
			if (max < arr[2]) {
				max = arr[2];
			}
			if (max < arr[3]) {
				max = arr[3];
			}
			document.getElementById("result").innerHTML = "최대 값   : " + max;

		},
		gugudan : function() {
			var i=0,j=0,hap=0,result='' ;
			j = Number(prompt('단을 입력'));
			for (var i=1; i <= 9; i++) {
				// 7단 구구단을 출력하시오
				hap = j*i
				result += (j+'*'+i+'='+ hap)+'<br/>' ;
			}
			document.getElementById("result").innerHTML = result;
		},
		sum1to100 : function() {
			var sum = 0, i = 0;
			while (i <= 100) {
				/* 1부터 100까지의 합을 출력하시오*/

				sum += i;
				i++;
			}

			document.getElementById("result").innerHTML = "1to100Sum : " + sum;

		},
		oddSum : function() {
			var oddSum = 0, evenSum = 0, limit = Number(prompt('홀수 짝수의 합을 구하기 위한 한계값 입력'));
			for (var i = 0; i < limit + 1; i++) {
				// 1부터 100 까지 수 중에서 홀수의 합 oddSum 과 
				// 짝수들의 합 evenSum 을 구하시오
				if (i % 2 == 0) {
					evenSum += i;
				} else {
					oddSum += i;
				}

			}
			document.getElementById("result").innerHTML = "oddSum : " + oddSum+"evenSum : " + evenSum;
		}

	}
</script>