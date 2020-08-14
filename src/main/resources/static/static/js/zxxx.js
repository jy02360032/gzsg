// JavaScript Document


// ����ѧϰ�����߿���tab�л�
					$(function(){
						$(".zxtabbox .zxtab a").mouseover(function(){
							$(this).addClass('zxon').siblings().removeClass('zxon');
							let list_index = $(this).index();
							let tab_index = $('.liftgA:visible').index();
							$('.zxtabbox > .zxcontent').eq(tab_index).find('.zxlistbox').hide();
							$('.zxtabbox > .zxcontent').eq(tab_index).find('.zxlistbox').eq(list_index).show();
							// $('.zxtabbox .zxcontent .zxlistbox:eq('+index+')').show();
						});
						
						var auto = 0;  //����1���Զ��л������������������Զ��л�
						if(auto ==1){
							var number = 0;
							var maxNumber = $('.zxtabbox .zxtab a').length;
							function autotab(){
								number++;
								number == maxNumber? number = 0 : number;
								$('.zxtabbox .zxtab a:eq('+number+')').addClass('zxon').siblings().removeClass('zxon');
								$('.zxtabbox .zxcontent .zxlistbox:eq('+number+')').show().siblings().hide();
							}
							var tabChange = setInterval(autotab,3000);
							//�����ͣ��ͣ�л�
							$('.zxtabbox').mouseover(function(){
								clearInterval(tabChange);
							});
							$('.zxtabbox').mouseout(function(){
								tabChange = setInterval(autotab,3000);
							});
						  }
					});
					