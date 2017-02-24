var
	gulp		= require('gulp'),
	gutil		= require('gulp-util'),
	minifyCss	= require('gulp-minify-css'),	// 压缩css
	plumber		= require('gulp-plumber'),	// 监控
	jshint		= require('gulp-jshint'),	// js压缩
	sass		= require('gulp-sass'),		// 编译sass
	sourcemaps	= require('gulp-sourcemaps'), // sass map file
	uglify		= require('gulp-uglify'),	// 压缩js
	concat		= require('gulp-concat'),	// 合并文件
	rename		= require('gulp-rename');	// 重命名

var
	base_src	= './static/',
	devBase_src = './static_dev/',
	src_js		= devBase_src + 'js/**/*.js',
	src_sass	= devBase_src + 'sass/**/*.scss',
	tar_js		= base_src + 'js/',
	tar_css		= base_src + 'css/';

/** 编译sass */
gulp.task('sass', function(done) {
	gulp.src(src_sass)
		.pipe(plumber())
		.pipe(sass({errLogToConsoel: true}))
		.pipe(gulp.dest(tar_css))
		.pipe(minifyCss({keepSpecialComments: 0}))
		.pipe(rename({extname: '.min.css'}))
		.pipe(gulp.dest(tar_css))
		.on('end', done);
});

/** js压缩 */
gulp.task('compactjs', function() {
	gulp.src(src_js)
		.pipe(plumber())
//		.pipe(concat('all.js'))
//		.pipe(gulp.dest(tar_js));
//		.pipe(rename('all.min.js'))
		.pipe(uglify())
		.pipe(gulp.dest(tar_js));
});

/** 监控任务 */
gulp.task('watch', function() {
	gulp.watch(src_sass, function() {
		console.log('scss file changed...');
		gulp.run('sass');
	});
	
	gulp.watch(src_js, function() {
		console.log('js file changed...');
		gulp.run('compactjs');
	});
});

/** 默认任务 */
gulp.task('default', function() {
	gulp.run('watch');
});

