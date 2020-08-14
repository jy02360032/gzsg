// JavaScript Document


// ����ѧϰ�ڲ�tab�л�
								$(function(){
									$(".nav_box .is-tabs a").mouseover(function(){
										$(this).addClass('aon').siblings().removeClass('aon');
										var index = $(this).index();
										number = index;
										$('.nav_box .subCate .liftgA').hide();
										$('.nav_box .subCate .liftgA:eq('+index+')').show();
									});
									
									var auto = 0;  //����1���Զ��л������������������Զ��л�
									if(auto ==1){
										var number = 0;
										var maxNumber = $('.nav_box .is-tabs a').length;
										function autotab(){
											number++;
											number == maxNumber? number = 0 : number;
											$('.nav_box .is-tabs a:eq('+number+')').addClass('aon').siblings().removeClass('aon');
											$('.nav_box .subCate .liftgA:eq('+number+')').show().siblings().hide();
										}
										var tabChange = setInterval(autotab,3000);
										//�����ͣ��ͣ�л�
										$('.nav_box').mouseover(function(){
											clearInterval(tabChange);
										});
										$('.nav_box').mouseout(function(){
											tabChange = setInterval(autotab,3000);
										});
									  }
								});
