/**
 * Created by p on 2017/5/7.
 */

function test_check_submit() {
    var info = {};
    var names = ["age", "health", "experience", "purpose", "rate", "date", "down", "spending", "state", "retire"];
    var x = "input:radio[name='age']:checked";
    for (var i = 0; i < names.length; i++) {
        x = "input:radio[name='" + names[i] + "']:checked";
        var value = $(x).val();
        var temp = i + 1;
        if (value != undefined) {
            info[temp + ""] = value;
        }
        else {
            alert("第" + temp + "题未选择");
            return;
        }
    }
    $.post("testCheck", info, function (data) {
        var types = ["谨慎型","稳健型","平衡型","进取型","激进型"];
        var contents =["您属于可以承担低风险而作风谨慎类型的投资者。您适合投资于以保本为主的投资工具，但您因此会牺牲资本升值的机会。",
                    "您属于可以承担低至中等风险类型的投资者。您适合投资于能够权衡保本而亦有若干升值能力的投资工具。",
                    "您属于可以承担中等风险类型的投资者。您适合投资于能够为您提供温和升值能力，而投资价值有温和波动的投资工具。",
                    "您属于可以承担中等至高风险类型的投资者。您适合投资于能够为您提供升值能力，而投资价值有波动的投资工具。",
                    "您属于可以承受高风险类型的投资者。您适合投资于能够为您提供高升值能力而投资价值波动大的投资工具。最坏的情况下，您可能失去全部投资本金并需对您投资所导致的任何亏蚀承担责任。"];
        var abilitys = ["低","中偏低","中","中偏高","高"];
        var expects = ["较低收益","中等偏低收益","中等收益","中等偏高收益","高收益"];
        var suggests = ["二级市场：20%，固定收益：45%，海外资产：10%，现金管理：25%",
                        "二级市场：15%，中长期股权：10%，固定收益：45%，海外资产：10%，现金管理：20%",
                        "二级市场：15%，中长期股权：20%，固定收益：40%，海外资产：10%，现金管理：15%",
                        "二级市场：20%，中长期股权：25%，固定收益：35%，海外资产：10%，现金管理：10%",
                        "二级市场：25%，中长期股权：30%，固定收益：30%，海外资产：10%，现金管理：5%"];
        var ret = JSON.parse(data);
        var temp = ret.cla - 1;
        $("#score").text(ret.sco);
        $("#type").text(types[temp]);
        $("#content").text(contents[temp]);
        $("#ability").text(abilitys[temp]);
        $("#except").text(expects[temp]);
        $("#suggest").text(suggests[temp]);
        var ModalEffects = (function () {

            function init() {

                var overlay = document.querySelector('.md-overlay');

                [].slice.call(document.querySelectorAll('.md-trigger')).forEach(function (el, i) {

                    var modal = document.querySelector('#' + el.getAttribute('data-modal')),
                        close = modal.querySelector('.md-close');

                    function removeModal(hasPerspective) {
                        classie.remove(modal, 'md-show');

                        if (hasPerspective) {
                            classie.remove(document.documentElement, 'md-perspective');
                        }
                    }

                    function removeModalHandler() {
                        removeModal(classie.has(el, 'md-setperspective'));
                    }

                    el.addEventListener('click', function (ev) {
                        classie.add(modal, 'md-show');
                        overlay.removeEventListener('click', removeModalHandler);
                        overlay.addEventListener('click', removeModalHandler);

                        if (classie.has(el, 'md-setperspective')) {
                            setTimeout(function () {
                                classie.add(document.documentElement, 'md-perspective');
                            }, 25);
                        }
                    });

                    close.addEventListener('click', function (ev) {
                        ev.stopPropagation();
                        removeModalHandler();
                    });

                });

            }

            init();

        })();
        (function (window) {

            'use strict';


            function classReg(className) {
                return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
            }

            var hasClass, addClass, removeClass;

            if ('classList' in document.documentElement) {
                hasClass = function (elem, c) {
                    return elem.classList.contains(c);
                };
                addClass = function (elem, c) {
                    elem.classList.add(c);
                };
                removeClass = function (elem, c) {
                    elem.classList.remove(c);
                };
            }
            else {
                hasClass = function (elem, c) {
                    return classReg(c).test(elem.className);
                };
                addClass = function (elem, c) {
                    if (!hasClass(elem, c)) {
                        elem.className = elem.className + ' ' + c;
                    }
                };
                removeClass = function (elem, c) {
                    elem.className = elem.className.replace(classReg(c), ' ');
                };
            }

            function toggleClass(elem, c) {
                var fn = hasClass(elem, c) ? removeClass : addClass;
                fn(elem, c);
            }

            var classie = {
                hasClass: hasClass,
                addClass: addClass,
                removeClass: removeClass,
                toggleClass: toggleClass,
                has: hasClass,
                add: addClass,
                remove: removeClass,
                toggle: toggleClass
            };

            if (typeof define === 'function' && define.amd) {
                define(classie);
            } else {
                window.classie = classie;
            }

        })(window);
        javascript:;
    });
}