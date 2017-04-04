import { HeliosPage } from './app.po';

describe('helios App', () => {
  let page: HeliosPage;

  beforeEach(() => {
    page = new HeliosPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
