
run: newrelic
	sbt run

newrelic:
	@ecbo "APMの画面 + Add more から、Java Agentをダウンロードして、"
	@ecbo "このディレクトリの下に展開してください。"
	@ecbo "そのあと、newrelic/newrelic.yml に、ライセンスキーを設定してください。"

test:
	curl -v "http://localhost:8888"
